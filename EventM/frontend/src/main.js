import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import {BootstrapVue, BootstrapVueIcons} from 'bootstrap-vue'
import VeeValidate from "vee-validate";
import Vuex from "vuex";
import setup from "@/services/setupInterceptors";

Vue.config.productionTip = false

Vue.use(Vuex)
Vue.use(BootstrapVue)
Vue.use(BootstrapVueIcons)
Vue.use(VeeValidate)

setup(store)

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import '@/assets/styles/main.css'
import '@/assets/styles/button.css'

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')