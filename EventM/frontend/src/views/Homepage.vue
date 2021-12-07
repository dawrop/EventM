<template>
    <div class="vue-template">
        <div class="App">
            <div class="">
                <Header/>
                <Sidebar/>
                <div class="content-container">
                    <div class="container-fluid">
                        <div class="jumbotron">
                            <h1>Events</h1>
                            <EventComponent/>
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

export default {
    components: {Sidebar, Header, EventComponent},
    data() {
        return {}
    },

}
</script>
<style scoped>

</style>