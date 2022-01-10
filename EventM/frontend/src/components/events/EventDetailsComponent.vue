<template>

    <div>
        <div id="element-to-print">
            <div class="eventPic border rounded shadow-lg" :style="{
            backgroundImage: 'url(' + require(`../../assets/eventPhotos/${ eventDetails.picture }.png`) + ')'
         }"/>

            <div class="card-body border" style="width: 600px; margin: 0 auto">
                <h2>Details</h2>
                <hr class="my-2">
                <div class="d-flex flex-column">
                    <div class="mt-3">
                        <p class="text-secondary mb-1">Name</p>
                        <h6>{{ eventDetails.title }}</h6>
                        <p class="text-secondary mb-1">Description</p>
                        <h6>{{ eventDetails.description }}</h6>
                        <p class="text-secondary mb-1">Host</p>
                        <h6>{{ eventDetails.user.name }}</h6>
                        <p class="text-secondary mb-1">Category</p>
                        <h6>{{ eventDetails.category }}</h6>
                        <p class="text-secondary mb-1">City</p>
                        <h6>{{ eventDetails.city }}</h6>
                        <p class="text-secondary mb-1">Address</p>
                        <h6>{{ eventDetails.address }}</h6>
                        <p class="text-secondary mb-1">Date</p>
                        <h6>{{ eventDetails.date }}</h6>
                        <p class="text-secondary mb-1">Time</p>
                        <h6>{{ eventDetails.time }}</h6>
                    </div>
                </div>
                <hr class="my-2">
                <div>
                    <p class="text-secondary mb-1" >Participants: {{ eventParticipants.length }}</p>

                    <div v-on:click="showParticipants">
                        <b-avatar-group  size="50px" overlap="0.35">
                            <b-avatar v-for="participant in eventParticipants" :key="participant.id" v-bind:src="require(`../../assets/avatars/${ participant.avatar }.png`)"></b-avatar>
                        </b-avatar-group>
                    </div>



                </div>

            </div>

        </div>
        <div class="d-flex flex-row align-items-center text-center justify-content-around" style="width: 600px; margin: 0 auto; padding-top: 10px">
            <input v-on:click="addToGoing" type="button" class="btn btn-myPrimary px-4" value="Going">
            <input v-on:click="exportAsPDF" type="button" class="btn btn-myPrimary px-4" value="Export as PDF">
        </div>
    </div>

</template>

<script>
import api from "@/services/api";
import html2pdf from 'html2pdf.js'

export default {
    name: "EventDetailsComponent",
    data() {
        return {
            eventDetails: [],
            eventParticipants: ''
        }
    },
    created() {
        api.get('/events/events/' + this.$route.params.eventId).then(response => {
            this.eventDetails = response.data
            console.log("Response " + JSON.stringify(this.eventDetails))
        })
        api.get('/events/eventParticipants/' + this.$route.params.eventId).then(response => {
            this.eventParticipants = response.data
            console.log("Response " + JSON.stringify(this.eventParticipants))
        })
    },
    methods: {
        exportAsPDF() {
            html2pdf(document.getElementById('element-to-print'), {
                margin: 10,
                filename: 'event.pdf',
                image: { type: 'jpeg', quality: 0.98 },
                html2canvas: { scale: 2, logging: true, dpi: 192, letterRendering: true },
                jsPDF: { unit: 'mm', format: 'a4', orientation: 'portrait' }
            })
        },
        addToGoing() {
            api.post('/events/goingEvents', {
                id: this.eventDetails.id
            })
            window.location.reload()
        },
        showParticipants() {
            this.$router.push({name: "participants", params: { participants: this.eventParticipants }})
        }
    }

}
</script>

<style >
    .eventDetails {

    }

    .eventPic {
        height: 250px;
        width: 600px;
        margin: 0 auto;
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
    }
</style>