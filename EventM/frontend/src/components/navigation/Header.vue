<template>
    <nav class="navbar shadow bg-white  justify-content-between flex-nowrap flex-row fixed-top">
        <div class="header-container">
            <a class="navbar-brand px-xl-5 float-left font-weight-bold" target="_blank">
                EventM
            </a>

            <ul class="nav navbar-nav flex-row float-right">
                <li class="nav-item p-2" v-if="checkIfLoggedIn" v-on:click.prevent="logout">
                    <router-link class="btn btn-outline-myPrimary" to="/login">Logout</router-link>
                </li>
                <li class="nav-item p-2" v-if="!checkIfLoggedIn">
                    <router-link class="btn btn-outline-myPrimary" to="/login">Login</router-link>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
import eventBus from "@/common/EventBus";
import TokenService from "@/services/token.service"

export default {
    name: "MainNavigation",
    components: {},
    data() {
        return {

        }
    },
    computed: {
        checkIfLoggedIn() {
            return TokenService.getUser()
        }
    },
    methods: {
        logout() {
            this.$store.dispatch('auth/logout')
            this.$router.push('/login')
        }
    },
    mounted() {
        eventBus.on("logout", () => {
            this.logout();
        })
    },
    beforeDestroy() {
        eventBus.remove("logout")
    }
}
</script>

<style scoped>

</style>