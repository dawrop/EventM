<template>
    <div class="vue-template">
        <router-view />
    </div>
</template>

<script>
    import EventBus from "./common/EventBus"

    export default {
        methods: {
            logOut() {
                this.$store.dispatch('auth/logout')
                this.$router.push("/login")
            },
            mounted() {
                EventBus.on("logout", () => {
                    this.logOut()
                })
            },
            beforeDestroy() {
                EventBus.remove("logout")
            }
        }
    }
</script>

<style>

</style>
