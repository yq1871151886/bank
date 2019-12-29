import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
Vue.config.productionTip = false

/* eslint-disable no-new */
Vue.prototype.$axios = axios
Vue.use(ElementUI)
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
