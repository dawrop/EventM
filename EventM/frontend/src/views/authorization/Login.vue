<template>
    <div class="vue-template">
        <div class="App">
            <div class="vertical-center">
                <div class="inner-block">
                    <StarterNavigation/>
                    <LoginContainer/>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import StarterNavigation from "@/components/navigation/StarterNavigation";
import LoginContainer from "@/components/authorization/LoginContainer";

export default {
    components: {
        StarterNavigation,
        LoginContainer
    },
    data() {
        return {

        }
    }
}
</script>