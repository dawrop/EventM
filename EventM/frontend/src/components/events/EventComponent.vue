<template>
        <b-card-group deck>
            <div v-for="event in filteredEvents" :key="event.id" style="padding-top: 15px; padding-bottom: 15px; max-width: 25rem; display: inline-block">
                <router-link :to="{ name: 'event', params: { eventId: event.id }}">
                    <b-card
                            :title="event.title"
                            :img-src="getImgURL(event.picture)"
                            img-alt="Image"
                            img-top
                            tag="article"
                    >
                        <b-card-text class="col nopadding">
                            <p class="text-secondary mb-1 nopadding">{{ event.date | formatDate }} at {{ event.time | formatTime }}</p>
                            <p class="text-secondary mb-1 nopadding">{{ event.city }}</p>
                        </b-card-text>
                    </b-card>

                </router-link>
            </div>
        </b-card-group>
</template>

<script>

import searchMixin from "@/mixins/searchMixin";

export default {
    name: "EventComponent",
    props: ['events', 'search'],
    methods: {
        getImgURL(imgFile) {
            let images = require.context("../../assets/eventPhotos", false, /\.png$/)
            return images("./" + imgFile + ".png")
        },

    },
    mixins: [searchMixin]
}
</script>

<style scoped>
    .card-img-top {
        width: 100%;
        height: 15vw;
        object-fit: cover;
    }

    .nopadding {
        padding: 0 !important;
        margin: 0 !important;
    }
</style>