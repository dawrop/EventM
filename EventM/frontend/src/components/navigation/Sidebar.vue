<template>
    <div class="sidebar-container">
        <!--        <div class="sidebar-logo">-->
        <!--            Project Name-->
        <!--        </div>-->
        <ul class="sidebar-navigation">
            <li class="header">Navigation</li>
            <li>
                <router-link to="/">
                    <i class="fa fa-home" aria-hidden="true"></i> Homepage
                </router-link>
            </li>
            <li>
                <router-link to="/users">
                    <i class="fa fa-tachometer" aria-hidden="true"></i> Users
                </router-link>
            </li>
            <li>
                <router-link to="/profile">
                    <i class="fa fa-tachometer" aria-hidden="true"></i> Profile
                </router-link>
            </li>
            <li class="header">Your Events</li>
            <li>
                <router-link to="/going">
                    <i class="fa fa-user" aria-hidden="true"></i> Going
                </router-link>
            </li>
            <li>
                <router-link to="/hosting">
                    <i class="fa fa-users" aria-hidden="true"></i> Hosting
                </router-link>
            </li>
            <li>
                <router-link to="/past">
                    <i class="fa fa-cog" aria-hidden="true"></i> Past events
                </router-link>
            </li>
            <li>
                <router-link to="/create">
                    <i class="fa fa-info-circle" aria-hidden="true"></i> Create event
                </router-link>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    name: "Sidebar"
}
</script>

<style scoped>

</style>