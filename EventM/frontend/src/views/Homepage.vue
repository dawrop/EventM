<template>
    <div class="vue-template">
        <div class="App">
            <div class="">
                <Header/>
                <Sidebar/>
                <div class="content-container">
                    <div class="container-fluid">
                        <div class="jumbotron">
                            <h1>Discover Events</h1>
                            <div class="input-group md-form form-sm form-2 pl-0">
                                <input class="form-control my-0 py-1 lime-border" type="text" v-model="search" placeholder="Search" aria-label="Search">
                            </div>
                            <EventComponent v-bind:events="events" v-bind:search="search"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Header from "@/components/navigation/Header"
import Sidebar from "@/components/navigation/Sidebar"
import EventComponent from "@/components/events/EventComponent";
import api from "@/services/api";

export default {
    components: {Sidebar, Header, EventComponent},
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