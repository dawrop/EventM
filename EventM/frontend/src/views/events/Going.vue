<template>
    <div class="vue-template">
        <div class="App">
            <div class="">
                <Header/>
                <Sidebar/>
                <div class="content-container">
                    <div class="container-fluid">
                        <div class="jumbotron">
                            <h1>Going events</h1>
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
import api from "@/services/api";
import EventComponent from "@/components/events/EventComponent";


export default {
    components: {Sidebar, Header, EventComponent},
    data() {
        return {
            events: []
        }
    },
    mounted() {
        api.get('/events/goingEvents').then(response => {
            this.events = response.data
            console.log("Response " + JSON.stringify(this.events))
        })
    }
}
</script>
<style scoped>

</style>