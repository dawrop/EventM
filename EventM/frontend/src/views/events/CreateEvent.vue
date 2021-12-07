<template>
    <div class="vue-template">
        <div class="App">
            <div class="">
                <Header/>
                <Sidebar/>
                <div class="content-container">
                    <div class="container-fluid">
                        <div class="jumbotron">
                            <h1 style="padding-bottom: 20px">Create event</h1>
                            <CreateEventComponent/>
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
import CreateEventComponent from "@/components/events/CreateEventComponent";

export default {
    name: "CreateEvent",
    components: {Sidebar, Header, CreateEventComponent},
}
</script>

<style scoped>

</style>