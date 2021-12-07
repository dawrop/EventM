<template>
    <!-- Navigation -->
    <nav class="navbar shadow bg-white rounded justify-content-between flex-nowrap flex-row fixed-top">
        <div class="container">
            <a class="navbar-brand float-left font-weight-bold" target="_blank">
                EventM
            </a>
            <ul class="nav navbar-nav flex-row float-right">
                <li class="nav-item p-2">
                    <router-link class="btn btn-outline-myPrimary" to="/login">Sign in</router-link>
                </li>
                <li class="nav-item p-2">
                    <router-link class="btn btn-outline-myPrimary" to="/signup">Sign up</router-link>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
export default {
    name: "StarterNavigation"
}
</script>

<style scoped>

</style>