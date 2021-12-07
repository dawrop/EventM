<template>
    <div >
        <b-list-group-item
                class="d-flex align-items-center"
                v-for="user in users" :key="user.id">
            <b-avatar class="mr-3" v-bind:src="require(`../../assets/avatars/${ user.avatar }.png`)"></b-avatar>
            <span class="mr-auto">{{ user.name }}</span>
        </b-list-group-item>
    </div>
</template>

<script>
import api from "@/services/api";

export default {
    name: "UsersContainer",
    data() {
        return {
            users: [],
        }
    },
    mounted() {
        api.get('/users/users').then(response => {
            this.users = response.data
            console.log("Response " + JSON.stringify(this.users))
        })
    }
}
</script>

<style scoped>

</style>