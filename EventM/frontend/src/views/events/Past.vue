<template>
    <div class="vue-template">
        <div class="App">
            <div class="">
                <Header/>
                <Sidebar/>
                <div class="content-container">
                    <div class="container-fluid">
                        <div class="jumbotron">
                            <h1>Past events</h1>
                            <div>
                                <h5>Events participated</h5>
                                <EventComponent v-bind:events="wentEvents"/>
                            </div>
                            <div>
                                <h5>Events hosted by you</h5>
                                <EventComponent v-bind:events="hostedEvents"/>
                            </div>

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
            wentEvents: [],
            hostedEvents: []
        }
    },
    mounted() {
        api.get('/events/wentEvents').then(response => {
            this.wentEvents = response.data
            console.log("Response " + JSON.stringify(this.wentEvents))
        })
        api.get('/events/hostedEvents').then(response => {
            this.hostedEvents = response.data
            console.log("Response " + JSON.stringify(this.hostedEvents))
        })
    }
}
</script>
<style scoped>

</style>