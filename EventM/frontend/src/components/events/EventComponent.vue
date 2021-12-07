<template>
        <b-card-group deck>
            <div v-for="event in events" :key="event.id" style="max-width: 25rem; display: inline-block">
                <router-link :to="{ name: 'event', params: { eventId: event.id }}">
                    <b-card
                            :title="event.title"
                            :img-src="getImgURL(event.picture)"
                            img-alt="Image"
                            img-top
                            tag="article"
                    />
                </router-link>
            </div>
        </b-card-group>
</template>

<script>
import api from "@/services/api";

export default {
    name: "EventComponent",
    data() {
        return {
            events: []
        }
    },
    methods: {
        getImgURL(imgFile) {
            let images = require.context("../../assets/eventPhotos", false, /\.png$/)
            return images("./" + imgFile + ".png")
        }
    },
    mounted() {
        api.get('/events/events').then(response => {
            this.events = response.data
            console.log("Response " + JSON.stringify(this.events))
        })
    }
}
</script>

<style scoped>
    .card-img-top {
        width: 100%;
        height: 15vw;
        object-fit: cover;
    }
</style>