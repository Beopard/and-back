  <template>
  <div>

      <button @click="goUsers">회원목록</button>
      <button @click="goPosts">게시글목록</button>

  </div>
  </template>

  <script>
  // import axios from 'axios'

  export default {
    name: "MainView",
    data() {
      return {
        exchangeRate:'bsh',
      }
    },
    computed:{

    },
    mounted() {
      // axios.get("/api/posts")
      //     .then((res)=>{
      //       this.exchangeRate=res.data
      //       console.log(res.data)
      //     });


    },
    methods: {
      goUsers(){
        this.$router.push({path:'/users'})
      },
      goPosts(){
        this.$router.push({path:'/posts'})
      }
    }
  }
  </script>

  <style scoped>

  </style>