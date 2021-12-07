<template>
    <form class="form" v-on:submit.prevent="handleRegister">
        <h3>Sign Up</h3>

        <div class="form-group">
            <label>Full Name</label>
            <input
                    v-model="user.name"
                    type="text"
                    class="form-control form-control-lg"
                    placeholder="Name Surname"/>
        </div>

        <div class="form-group">
            <label>Email address</label>
            <input
                    v-model="user.email"
                    type="email"
                    class="form-control form-control-lg"
                    placeholder="email@e.com"/>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input
                    v-model="user.password"
                    type="password"
                    class="form-control form-control-lg"
                    placeholder="Password"/>
        </div>

        <div class="form-group">
            <label>Repeat password</label>
            <input
                    v-model="user.repeatPassword"
                    type="password"
                    class="form-control form-control-lg"
                    placeholder="Password"/>
        </div>

        <button
                type="submit"
                class="btn btn-dark btn-lg btn-block">Sign Up
        </button>

        <p class="forgot-password text-right">
            Already registered?
            <router-link :to="{name: 'login'}" class="font-weight-bold">Sign In</router-link>
        </p>
    </form>
</template>

<script>
import User from "../../models/user"

export default {
    name: "SignUpContainer",
    data() {
        return {
            user: new User('', '', '', ''),
            submitted: false,
            successful: false,
            message: ''
        }
    },
    computed: {
        loggedIn() {
            return this.$store.state.auth.loggedIn;
        }
    },
    mounted() {
        if (this.loggedIn) {
            this.$router.push('/')
        }
    },
    methods: {
        handleRegister() {
            this.message = ''
            this.submitted = true
            this.$store.dispatch('auth/register', this.user).then(
                    data => {
                        this.message = data.message
                        this.successful = true
                    },
                    error => {
                        this.message =
                                (error.response && error.response.data) ||
                                error.message ||
                                error.toString();
                        this.successful = false
                    }
            )
            this.$router.push('/login')
        }
    }
}
</script>

<style scoped>

</style>