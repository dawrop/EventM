<template>
    <section>
        <form v-on:submit.prevent="sendEventData">
            <div class="form-group">
                <label>Title</label>
                <b-form-input
                        v-model="event.title"
                        type="text"
                        class="form-control form-control-lg"
                        style="border-color: #DCDCDCFF"/>
            </div>
            <div class="form-group">
                <label>Description</label>
                <textarea
                        v-model="event.description"
                        class="form-control form-control-lg"
                        style="border-color: #DCDCDCFF"/>
            </div>
            <div class="form-group">
                <label>Category</label>
                <Multiselect
                        v-model="event.category"
                        :options="options"
                        :clear-on-select="false"
                        :preserve-search="true"
                        placeholder="Pick some"
                        label="categoryName" track-by="categoryName"
                        >

                    <template
                            slot="selection"
                            slot-scope="{ values, search, isOpen }">
                        <span class="multiselect__single"
                              v-if="values.length &amp;&amp; !isOpen">{{ values.length }} options selected</span></template>
                </Multiselect>
            </div>
            <div class="form-group">
                <label>Address</label>
                <b-form-input
                        v-model="event.address"
                        type="text"
                        class="form-control form-control-lg"
                        style="border-color: #DCDCDCFF"/>
            </div>
            <div class="form-group">
                <label>Date</label>
                <b-form-input
                        v-model="event.date"
                        type="date"
                        class="form-control form-control-lg"
                        style="border-color: #DCDCDCFF"/>
            </div>
            <div class="form-group">
                <label>Time</label>
                <b-form-timepicker
                        v-model="event.time"
                        class="form-control form-control-lg"
                        style="border-color: #DCDCDCFF"/>
            </div>
<!--            <div class="form-group">-->
<!--                <label>Upload picture</label>-->
<!--                <b-form-file-->
<!--                        v-model="event.picture"-->
<!--                        :state="Boolean(event.picture)"-->
<!--                        accept=".png, .jpg"-->
<!--                        class="form-control form-control-lg"-->
<!--                        style="border-color: #DCDCDCFF"-->
<!--                />-->
<!--            </div>-->

            <button
                    type="submit"
                    class="btn btn-dark btn-lg btn-block"
                    style="width: min-content"
            >Create</button>
        </form>
    </section>
</template>

<script>
import Multiselect from 'vue-multiselect'
import Event from "@/models/event";
import api from "@/services/api";

export default {
    name: "CreateEventComponent",
    components: { Multiselect },
    data() {
        return {
            event: new Event('', '','','','','','', ''),
            options: [
                {categoryName: 'Art'},
                {categoryName: 'Comedy'},
                {categoryName: 'Dance'},
                {categoryName: 'Drinks'},
                {categoryName: 'Film'},
                {categoryName: 'Fitness'},
                {categoryName: 'Food'},
                {categoryName: 'Games'},
                {categoryName: 'Literature'},
                {categoryName: 'Misc'},
                {categoryName: 'Music'},
                {categoryName: 'Party'},
                {categoryName: 'Sports'},
            ]
        }
    },
    methods: {
        handleSubmit: function () {
            console.log(this.event)
        },
        sendEventData() {
            api.post('/events/events', {
                title: this.event.title,
                description: this.event.description,
                category: this.event.category.categoryName,
                address: this.event.address,
                date: this.event.date,
                time: this.event.time,
                hostId: this.currentUser.id
            }).then(response => {
                console.log(response.data)
                this.$router.push('/')
            }).catch(console.error)
        }
    },
    mounted() {
        api.get('/users/me').then(response => {
            console.log("Response " + JSON.stringify(response.data))
            this.currentUser = response.data
        })
    }

}
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css">

</style>