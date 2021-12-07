<template>
    <div class="vue-template">
        <div class="App">
            <div class="">
                <Header/>
                <Sidebar/>
                <div class="content-container">
                    <div class="container-fluid">
                        <div class="jumbotron">
                            <h1 style="padding-bottom: 20px">Registered users</h1>
                            <b-list-group >
                                <UsersContainer/>
                            </b-list-group>
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
import UsersContainer from "@/components/users/UsersContainer";

export default {
    name: "Users",
    components: {UsersContainer, Sidebar, Header},
    data() {
        return {}
    }
}
</script>

<style scoped>

</style>