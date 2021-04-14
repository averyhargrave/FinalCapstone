<template>
    <div :style="image" class="background-image">
    <div class="ItineraryDetail">
        <h1 style="margin-top: 100px;">{{itinerary.startingPoint}}</h1>
        <button class="edit" v-on:click="itineraryCreated = !itineraryCreated">Edit</button>
        
        
        <form class="center" v-if="itineraryCreated" v-on:submit.prevent="editItinerary">
            <label for="startingPoint">Itinerary Name:</label><br>
            <input type="text" id="startingPoint" name="startingPoint" v-model="itinerary.startingPoint"><br>
            <label for="date">Date:</label><br>
            <input type="text" id="date" name="date" v-model="itinerary.date"><br>
            <button type="submit">Edit Itinerary </button>
        </form>
        
        <!-- Loop through destinations array and display names after search -->
        <ul>        
            <li class="center" v-for="destination in destinations" v-bind:key="destination.destinationId">
                <button v-on:click="removeFromItinerary(destination)">Remove From Itinerary</button>
                <router-link :to="{ name: 'DestinationDetail', params: { id: destination.destinationId}}" class="destinationDetail">
                    {{ destination.name }}
                </router-link>
            </li>
        </ul>
        
       <button class="delete" v-on:click="deleteItinerary">Delete</button>     
       <GoogleMap class="map" :destinations="destinations"/>
    </div>
    </div>
</template>

<script>
import ItineraryServices from '../services/ItineraryServices.js'
import GoogleMap from '../components/GoogleMap.vue'

export default {
    components: {
    GoogleMap
  },
    name: 'Home',
    created() {
        ItineraryServices.getItineraryByItineraryId(this.$route.params.id).then(response => {
            this.itinerary = response.data;
        });
        ItineraryServices.viewDestinationsByItineraryId(this.$route.params.id).then(response => {
            this.destinations = response.data;
        });
    },
    data() {
        return {
            itinerary: [],
            destinations: [],
            itineraryCreated: false,
            image: { backgroundImage: "url(https://cleveland-bookkeeping.com/wp-content/uploads/2016/06/Moonrise-over-the-Cleveland-Ohio-skyline-and-Lake-Erie.jpg)"}
        }
    },
    methods: {
        deleteItinerary() {

            ItineraryServices.deleteItinerary(this.itinerary.itineraryId).then(() => {
                this.$router.push('/')
            })
        },
        editItinerary() {
            ItineraryServices.editItinerary(this.itinerary.startingPoint, this.itinerary.date, this.itinerary.itineraryId).then(() => {
                this.itineraryCreated = false;
            })
            
        },
        changeCreated() {
             if (this.itineraryCreated === true) {
                this.itineraryCreated = false;
            } else {
            this.itineraryCreated = true;
            }
        },
        removeFromItinerary(destination) {
            const index = this.destinations.indexOf(destination);
            this.destinations.splice(index, 1);
            ItineraryServices.deleteDestinationFromItinerary(destination.destinationId);
        }
    }
}
</script>

<style scoped>

.ItineraryDetail {
    
}

h1 {
    display: flex;
    justify-content: center;
    
}

.center {
    display: flex;
    justify-content: center;
}

.destinationDetail {
    display: flex;
    justify-content: center;
}

form.center {
    display: flex;
    align-items: center;
}

.delete {
    display: flex;
    margin-left: auto;
    margin-right: 20%;
    margin-top: 50px;
}

.edit {
    margin-left: 20%;

}
div.background-image {
        background-size: cover;
        background-repeat: no-repeat;
        height: 100%;
        padding-top: 10px;
    }

.map {
    margin-left: 5%;
    margin-right: 5%;
}

</style>
