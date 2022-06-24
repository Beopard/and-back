import Vue from 'vue';
import VueX from 'vuex';
import user from './modules/user';
import createPersistedState from 'vuex-persistedstate'

Vue.use(VueX);

export const store = new VueX.Store({

  modules: {
    user,
  },
  plugins: [createPersistedState({
    paths: ["user"]
  })]
});
