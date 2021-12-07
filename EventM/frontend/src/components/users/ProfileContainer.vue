<template>
    <div class="content-container">
        <div class="container-fluid">
            <div class="jumbotron">
                <div class="container">
                    <div class="main-body">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="card" >
                                    <div class="card-body">
                                        <hr class="my-4">
                                        <div class="d-flex flex-column align-items-center text-center">
                                            <img
                                                    v-bind:src="require(`@/assets/avatars/${ currentUser.avatar }.png`)"
                                                    alt="Admin"
                                                    class="rounded-circle p-1 "
                                                    width="110"
                                                    style="background-color: #1E5128">
                                            <div class="mt-3">
                                                <h4>{{ currentUser.name }}</h4>
                                                <p class="text-secondary mb-1">{{ currentUser.email }}</p>
                                            </div>
                                        </div>
                                        <hr class="my-4">
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8">
                                <div class="card">
                                    <div class="card-body" style="justify-content: center">
                                        <h1 style="padding-bottom: 20px">Change password</h1>
                                        <div class="row mb-3" style="align-items: center">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Old password</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                <input type="password" class="form-control">
                                            </div>
                                        </div>
                                        <div class="row mb-3" style="align-items: center">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">New password</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                <input type="password" class="form-control">
                                            </div>
                                        </div>
                                        <div class="row mb-3" style="align-items: center">
                                            <div class="col-sm-3">
                                                <h6 class="mb-0">Repeat new password</h6>
                                            </div>
                                            <div class="col-sm-9 text-secondary">
                                                <input type="password" class="form-control">
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-sm-3"></div>
                                            <div class="col-sm-9 text-secondary">
                                                <input type="button" class="btn btn-myPrimary px-4" value="Save Changes">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import api from "@/services/api";
import UserDetails from "@/models/userDetails";

export default {
    name: "ContentContainer",
    data() {
        return {
            currentUser: new UserDetails('', '', '', '')
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

<style>
body{
    background: #f7f7ff;
    margin-top:20px;
}
.card {
    position: relative;
    display: flex;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 0 solid transparent;
    border-radius: .25rem;
    margin-bottom: 1.5rem;
    box-shadow: 0 2px 6px 0 rgb(218 218 253 / 65%), 0 2px 6px 0 rgb(206 206 238 / 54%);
}
.me-2 {
    margin-right: .5rem!important;
}

</style>