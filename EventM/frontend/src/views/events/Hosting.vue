<template>
    <div class="vue-template">
        <div class="App">
            <div class="">
                <Header/>
                <Sidebar/>
                <div class="content-container">
                    <div class="container-fluid">
                        <div class="jumbotron">
                            <h1>Events hosted by you</h1>
                            <EventComponent v-bind:events="events"/>
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
            events: []
        }
    },
    mounted() {
        api.get('/events/hostingEvents').then(response => {
            this.events = response.data
            console.log("Response " + JSON.stringify(this.events))
        })
    }
}
</script>
<style scoped>

</style>