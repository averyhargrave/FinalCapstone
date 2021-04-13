<template>
    <div class="DestinationDetail" v-if="!isLoading">
        <h1 style="text-center">{{destination.name}}</h1>
        <!-- drop-down up here that lists through user itineraries -->
        <button v-on:click="postToItinerary">Add to Itinerary</button>
        
            <select name="oneOption" id="itineraryList" v-model="itinerary">
            <option v-for="itinerary in userItineraries" :key="itinerary.itineraryId" :value="itinerary.itineraryId">{{itinerary.startingPoint}}</option>
            </select>

        <div class="rating">
            <!-- Thumbs up -->
        <div class="like grow"  v-on:click="thumbsUp">
            <i class="fa fa-thumbs-up fa-3x like" :class="{'active' : isLiked }" aria-hidden="true" id="like"></i>
        </div>
             <!-- Thumbs down -->
  <div class="dislike grow" v-on:click="thumbsDown">
    <i class="fa fa-thumbs-down fa-3x like" aria-hidden="true" id="dislike" :class="{'active' : !isLiked }"></i>
  </div>

        
        <!-- pushes you to itineraryDetail -->
        <h2>{{destination.description}}</h2>
        <div class="Hours" v-for="anHour in destination.hours" :key="anHour.hourId">
            <h3>{{anHour.dayOfWeek}}: 
                {{anHour.open}} -
                {{anHour.close}}  

           </h3>

        </div>
        <a :href="destination.website">{{destination.website}}</a>

        <img :src="destination.image" alt="Landmark Image" class="center">
    </div>
    </div>
</template>

<script>
import DestinationServices from '../services/DestinationServices'
import ItineraryServices from '../services/ItineraryServices'


export default {
    created() {
        
        DestinationServices.getADestination(this.$route.params.id).then(response => {
            this.destination = response.data[0]
            console.log(this.destination)

            DestinationServices.getDestinationHours(this.$route.params.id).then(res => {
                this.destination.hours = res.data
                this.isLoading = false;
                console.log(this.destination)
        
                ItineraryServices.getItineraryByUserId(this.$store.state.user.id).then(response => {
                    this.userItineraries = response.data;
                })
            })   
        });
    },
    data() {
        return {
            destination: {},
            isLoading: true,
            itineraries: [],
            userItineraries: [],
            itinerary: [],
            isLiked: false,
            
        }

        
    },

    methods: {
     thumbsUp() {
        this.isLiked = true
    },

     thumbsDown() {
        this.isLiked = false
    },

    postToItinerary() {
        ItineraryServices.addToItinerary(this.destination.destinationId, this.itinerary).then(() => {
        this.$router.push({name:"ItineraryDetail", params:{id:this.itinerary}});
        })
     
    }


  } 
}

</script>

<style scoped>

h1 {
    display: flex;
    color: black;
    justify-content: center;

}

button {
    display: flex;
    justify-content: center;
    margin: auto;
}

select {
    display: flex;
    justify-content: center;
    margin: auto;
}

h2 {
    display: flex;
    color: black;
    justify-content: center;
    margin: 20px;
    padding: 20px;
}

.Hours {
    display: flex;
    color: black;
    justify-content: center; 
    margin: -30px;
    
    
}

.center {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 800px;
    border-radius: 10px;

}


a {
    display: flex;
    color: black;
    justify-content: center;
    margin: 30px;
}
 
 a:hover {
     color: red

 }

.rating {
  display: inline-block;
  width: 100%;
  margin-top: 40px;
  padding-top: 40px;
  text-align: center;
}

.like,
.dislike {
  display: inline-block;
  cursor: pointer;
  margin: 10px;
}

.dislike:hover,
.like:hover {
  color: #2EBDD1;
  transition: all .2s ease-in-out;
  transform: scale(1.1);
}

.active {
  color: #2EBDD1;
}
</style>