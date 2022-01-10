<template>
    <div>
        <h1 style="padding-bottom: 20px">Participants</h1>
        <b-list-group >
            <b-list-group-item
                    class="d-flex align-items-center"
                    v-for="participant in participants" :key="participant.id">
                <b-avatar class="mr-3" v-bind:src="require(`../../assets/avatars/${ participant.avatar }.png`)"></b-avatar>
                <span class="mr-auto">{{ participant.name }}</span>
            </b-list-group-item>
        </b-list-group>
    </div>
</template>

<script>
export default {
    name: "ParticipantsContainer",
    data() {
        return {
            participants: [],
        }
    },
    created() {
        this.participants = this.$route.params.participants
    }
}
</script>

<style scoped>

</style>