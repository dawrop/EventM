<template>
    <section>
        <form v-on:submit.prevent="handleSubmit">
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
                <label>City</label>
                <b-form-input
                        v-model="event.city"
                        type="text"
                        class="form-control form-control-lg"
                        style="border-color: #DCDCDCFF"/>
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
                        reset-button
                        style="border-color: #DCDCDCFF"/>
            </div>
            <div class="form-group">
                <label>Upload picture</label>
                <b-form-file
                        ref="eventPic"
                        :state="Boolean(event.picture)"
                        accept=".png, .jpg"
                        class="form-control form-control-lg"
                        style="border-color: #DCDCDCFF"
                />
            </div>

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
            event: new Event('', '','','','', '','', ''),
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
        handleSubmit() {
            this.sendEventPic()
        },
        sendEventPic() {
            let user = JSON.parse(localStorage.getItem("user"));
            let eventPicFile = this.$refs.eventPic.files[0];
            let reqBody = new FormData();
            reqBody.append("file", eventPicFile)
            fetch("http://localhost:8080/api/files/eventPics", {
                method: "post",
                body: reqBody,
                credentials: "omit",
                headers: {
                    'Authorization': 'Bearer ' + user.accessToken
                }
            }).then(response => {
                if (response.status === 200)
                    return response
                throw response.status
            })
                .then(response => response.json())
                .then(reqBody => {
                    this.event.picture = reqBody.message
                    this.sendEventData()
                })
                .catch(console.error)
        },
        sendEventData() {
            api.post('/events/addEvent', {
                title: this.event.title,
                description: this.event.description,
                category: this.event.category.categoryName,
                city: this.event.city,
                address: this.event.address,
                date: this.event.date,
                time: this.event.time,
                picture: this.event.picture,
            }).then(response => {
                console.log(response.data)
                this.$router.push('/')
            }).catch(console.error)
        }
    }

}
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css">

</style>