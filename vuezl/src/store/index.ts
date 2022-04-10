import { createStore } from "vuex";

export default createStore({
  state: {
    user: {
      id: "",
      email: "",
      username: "",
      nickname: "",
      phonenumber: "",
      description: "",
      password: "",
      regTime: "",
      role: "",
      enabled: "",
    },
    isLogin: false,
  },
  mutations: {
    setUserId(state, user_id) {
      state.user.id = user_id;
    },
    setUserEmail(state, user_email) {
      state.user.email = user_email;
    },
    setUserUsername(state, user_username) {
      state.user.username = user_username;
    },
    setUserNickname(state, user_nickname) {
      state.user.nickname = user_nickname;
    },
    setUserPhonenumber(state, user_phonenumber) {
      state.user.phonenumber = user_phonenumber;
    },
    setUserDescription(state, user_description) {
      state.user.description = user_description;
    },
    setUserPassword(state, user_password) {
      state.user.password = user_password;
    },
    setUserRegTime(state, user_regTime) {
      state.user.regTime = user_regTime;
    },
    setUserRole(state, user_role) {
      state.user.role = user_role;
    },
    setUserEnabled(state, user_enabled) {
      state.user.enabled = user_enabled;
    },
    setIsLogin(state, isLogin) {
      state.isLogin = isLogin;
    },
  },
  actions: {},
  modules: {},
});
