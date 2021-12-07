<template>
    <div class="vue-template">
        <!-- Main -->
        <div class="App">
            <div class="vertical-center">
                <div class="inner-block">
                    <StarterNavigation/>
                    <SignUpContainer/>

                </div>
            </div>
        </div>

    </div>
</template>

<script>
import StarterNavigation from "@/components/navigation/StarterNavigation";
import SignUpContainer from "@/components/authorization/SignUpContainer";

export default {
    components: {
        StarterNavigation,
        SignUpContainer
    },
    data() {
        return {

        }
    }

}


</script>