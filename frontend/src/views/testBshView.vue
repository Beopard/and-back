<template>
<div>
  <v-card>
    TestBshView
    {{ exchangeRate }}
  </v-card>
</div>
</template>

<script>
import axios from 'axios'

export default {
  name: "TestBshView",
  data() {
    return {
      exchangeRate:'bsh',
    }
  },
  computed:{

  },
  mounted() {
    axios.get("/api/posts")
        .then((res)=>{
          this.exchangeRate=res.data
          console.log(res.data)
        });


  },
  methods: {
  }
}
</script>

<style scoped>

</style>