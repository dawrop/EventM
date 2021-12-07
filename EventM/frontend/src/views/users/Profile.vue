<template>
    <div class="vue-template">
        <div class="App">
            <div class="">
                <Header/>
                <Sidebar/>
                <ProfileContainer/>
            </div>
        </div>
    </div>
</template>

<script>
import Header from "@/components/navigation/Header"
import Sidebar from "@/components/navigation/Sidebar"
import ProfileContainer from "@/components/users/ProfileContainer";

export default {
    components: {ProfileContainer, Sidebar, Header},
    computed: {
        currentUser() {
            return this.$store.state.auth.user
        }
    }

}
</script>

<style scoped>

</style>