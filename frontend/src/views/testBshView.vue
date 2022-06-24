<template>
<div>
  <v-card>
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
      dialogAdd:[true,true],
      message:'hello world',
      array:['array'],
      dialog:false,
      abc:{'pl_id':'123'},
      mapTest:'',
      mapTest2:[]
    }
  },
  computed:{
    reverse: function() {
      console.log('I am computed :: reverse')
      var a = this.message.split('').reverse().join('')
      return a
    },
    now: function() { // 아무곳에도 의존하지 않기때문에 절대로 업데이트 되지 않는다.
      console.log('I am computed :: now')
      return Date.now()
    }

  },
  mounted() {
    axios.get("/api/posts")
        .then((res)=>{
          this.exchangeRate=res.data
          console.log(res.data)
        });


    // (async () => {
    //   const condition = false;
    //   const promise = new Promise((resolve, reject) => {
    //     if (condition) {
    //       resolve('resolved');
    //     } else {
    //       reject('rejected');
    //     }
    //   });
    //
    //   try {
    //     const result = await promise;
    //     console.log(result);
    //   } catch (err) {
    //     console.error(err);
    //   }
    // })();
  },
  methods: {
    changeBoolean(i){
      this.dialogAdd[i]=!this.dialogAdd[i];
      console.log(this.dialogAdd)
    },
    inputArray(){
      this.mapTest2.push(1)
      this.mapTest2.pop()
      this.array['i']='i'
      // this.array.push('asdf')
      this.mapTest = new Map()
      this.mapTest.set('a',1)
      this.mapTest.set('a',2)
      alert(this.mapTest.get('a'))
      // this.$set(this.array,0,this.array[0])
      // this.$set(this.abc,'pl_id',456)
      // this.array.push('asdf')

      this.$nextTick(function(){
      })

    },
    goDetail(){
      this.$router.push({name:'bshDetail',params:{id:'123'},query:{bsh:this.message}})
    }
  }
}
</script>

<style scoped>

</style>