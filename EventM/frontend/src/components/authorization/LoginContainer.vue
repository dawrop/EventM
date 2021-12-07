<template>
    <form v-on:submit.prevent="handleSubmit">
        <h3>Sign In</h3>

        <div class="form-group">
            <label>Email address</label>
            <input
                    type="email"
                    v-model="user.email"
                    class="form-control form-control-lg"/>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input
                    type="password"
                    v-model="user.password"
                    class="form-control form-control-lg" />
        </div>

        <button
                type="submit"
                class="btn btn-dark btn-lg btn-block"
        >Sign In</button>

<!--        <p class="forgot-password text-right mt-2 mb-4">-->
<!--            <router-link to="/forgot-password">Forgot password?</router-link>-->
<!--        </p>-->

<!--        <div class="social-icons">-->
<!--            <ul>-->
<!--                <li><a href="#"><i class="fa fa-google"></i></a></li>-->
<!--                <li><a href='#'><i class="fa fa-facebook"></i></a></li>-->
<!--                &lt;!&ndash;                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>&ndash;&gt;-->
<!--            </ul>-->
<!--        </div>-->

    </form>
</template>

<script>
import User from '../../models/user'

export default {
    name: "LoginContainer",
    data() {
        return {
            user: new User('', ''),
            loading: false,
            message: ''
        }
    },
    computed: {
        loggedIn() {
            return this.$store.state.auth.status.loggedIn
        }
    },
    created() {
        if (this.loggedIn) {
            this.$router.push('/')
        }
    },
    methods: {
        handleSubmit() {
            this.loading = true

            if (this.user.email && this.user.password) {
                this.$store.dispatch('auth/login', this.user).then(
                        () => {
                            this.$router.push('/')
                        },
                        error => {
                            this.loading = false
                            this.message =
                                    (error.response && error.response.data) ||
                                    error.message ||
                                    error.toString()
                        }
                )
            }
        }
    }
}
</script>

<style scoped>

</style>