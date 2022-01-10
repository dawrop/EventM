<template>
    <div class="vue-template">
        <div class="App">
            <div class="">
                <Header/>
                <Sidebar/>
                <div class="content-container">
                    <div class="container-fluid">
                        <b-jumbotron>
                            <header>
                                <h1>Discover Events</h1>
                                <div>
                                    <button class="btn btn-outline-myPrimary mr-4">Most popular</button>
                                    <button class="btn btn-outline-myPrimary mr-4">Local</button>
                                    <button class="btn btn-outline-myPrimary mr-4">This week</button>

                                    <div class="w-25 float-right">
                                        <input class="form-control my-0 py-1 lime-border" type="text" v-model="search" placeholder="Search" aria-label="Search">
                                    </div>
                                </div>

                            </header>
                            <EventComponentHp v-bind:events="events" v-bind:search="search"/>
                        </b-jumbotron>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Header from "@/components/navigation/Header"
import Sidebar from "@/components/navigation/Sidebar"
import EventComponentHp from "@/components/events/EventComponentHp";
import api from "@/services/api";

export default {
    components: {Sidebar, Header, EventComponentHp},
    data() {
        return {
            events: [],
            search: ''
        }
    },
    mounted() {
        api.get('/events/events').then(response => {
            this.events = response.data
            console.log("Response " + JSON.stringify(this.events))
        })
    },

}
</script>
<style scoped>

</style>