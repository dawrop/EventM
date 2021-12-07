<template>
    <div class="vue-template">
        <div class="App">
            <div class="vertical-center">
                <div class="inner-block">
                    <StarterNavigation/>
                    <form>
                        <h3>Forgot Password</h3>

                        <div class="form-group">
                            <label>Email address</label>
                            <input type="email" class="form-control form-control-lg" />
                        </div>

                        <button type="submit" class="btn btn-dark btn-lg btn-block">Reset password</button>

                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import StarterNavigation from "@/components/navigation/StarterNavigation";
export default {
    components: {StarterNavigation},
    data() {
        return {}
    }
}
</script>