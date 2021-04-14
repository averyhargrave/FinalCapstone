<template> <!-- HTML goes here -->
    <div id="main">
        <h1>Explore Cleveland</h1>
        <div class="destinations">
            <div class="status-message error" v-show="errorMsg != ''">{{errorMsg}}</div>
            <div class="loading" v-if="isLoading">
                <!-- We can put an image here later -->
            </div>
        <div> <!-- We need to figure out how to do a search box up here -->
            <form v-if="!isSubmitted" v-on:submit.prevent="filterDestinations">
                <input v-model="searchTerm" placeholder="Search for a landmark"/>  <!-- two-way binds to searchTerm, attach to API request -->
                <label for="SearchBy"></label>

        <select name="SearchBy" id="Search By" v-model="searchType">
            <option value="" >Search By</option>
            <option value="zipcode">Zipcode</option>
            <option value="venuetype">Venue Type</option>
            <option value="name">Name</option>
            <option value="listAll">List All</option>
        </select>
        <button v-on:click="filterDestinations">Search</button>    <!-- might need to add something here -->
        <button v-if="!showCreatedForm" v-on:click="changeCreated">Create Itinerary</button>
        <button v-if="showCreatedForm" v-on:click="changeCreated">Cancel</button>
        <form v-if="showCreatedForm" v-on:submit.prevent="createItinerary">
            <label for="startingPoint" class="center">Starting point:</label><br>
            <input type="text" class="center" id="startingPoint" name="startingPoint" v-model="startingPoint"><br>
            <label for="date" class="center">Date:</label><br>
            <input type="text" id="date" name="date" v-model="date" class="center"><br>
            <button type="submit" class="center">Create Itinerary</button>
        </form>
        <br/>
         <select v-if="userItineraries.length > 0" name="oneOption" id="itineraryList" class="center" v-model="selectedItinerary">
            <option v-for="itinerary in userItineraries" :key="itinerary.itineraryId" :value="itinerary.itineraryId">{{itinerary.startingPoint}}</option>
            </select>
            <button class="center" v-on:click="viewItinerary">View Itinerary</button>        
                 <router-link :to="{ name: 'register' }" v-if="!this.$store.state.token">Create an account</router-link>
            </form>
            <div v-else>
            <button v-on:click="postToItinerary" class="center"> Add to Itinerary </button> 
            <select v-if="userItineraries.length > 0" name="oneOption" id="itineraryList" v-model="selectedItinerary" class="center">
            <option v-for="itinerary in userItineraries" :key="itinerary.itineraryId" :value="itinerary.itineraryId">{{itinerary.startingPoint}}</option>
            </select>
                <!-- Loop through destinations array and display names after search -->
                <ul>
                    <span style="background-color:white;"></span>
                    
                    <li class="checks" v-for="destination in destinations" v-bind:key="destination.destinationId">
                        <input type="checkbox" v-on:change="addToItinerary($event, destination.destinationId)"/>
                        <router-link :to="{ name: 'DestinationDetail', params: { id: destination.destinationId}}" class="destinationDetail">
                            {{ destination.name }}
                        </router-link>
                        <!-- Button to create or add to itinerary -->
                    </li>
                </ul>
                <button v-on:click="cancelSearch" class="center">Cancel</button>
            </div>
            <!--<router-link>See all landmarks</router-link> -->
        </div>
        </div>
    </div>
       <!-- <img href="https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-cont[…]F11%2Fskyline-cleveland-ohio-VISITCLEVELAND0917.jpg&q=85"></img> -->
</template>

<script> // Vue goes here
import DestinationService from '../services/DestinationServices';
import ItineraryServices from '../services/ItineraryServices';

export default {
    data() {
        return {
            destinations: [],
            errorMsg: '',
            searchTerm: '',
            searchType: '',
            isSubmitted: false,
            isLoading: false,
            itinerary: [],
            userItineraries: [],
            selectedItinerary: null,
            showCreatedForm: false,
            startingPoint: '',
            date: ''
        }
    },
    created() {
        ItineraryServices.getItineraryByUserId(this.$store.state.user.id).then(response => {
            this.userItineraries = response.data
        })
    },
    methods: {
        // Create method that takes the service method and sets response.data to this.destinations
        filterDestinations() {
            console.log(`searchType: ${this.searchType}`)
            // Use services to get destinations that match the searchTerm
            if (this.searchType === 'listAll') {
                DestinationService.getDestinations().then(response => {
                    this.destinations = response.data
                   // this.destinations.filter(destination => destination.name == this.searchTerm).filter(destination => destination.type == this.searchTerm) // Chain more filters here (OR statements in SQL)
                    this.isSubmitted = true;
                })
            } else if (this.searchType === 'name') {
                DestinationService.getDestinationByName(this.searchTerm).then(response => {
                    this.destinations = response.data
                    this.isSubmitted = true;
                })
            } else if (this.searchType === 'zipcode') {
                DestinationService.getDestinationByZip(this.searchTerm).then(response => {
                    this.destinations = response.data
                    this.isSubmitted = true;
                })
            } else if (this.searchType === 'venuetype') {
                 DestinationService.getDestinationByVenueType(this.searchTerm).then(response => {
                    this.destinations = response.data
                    this.isSubmitted = true;
                })
            }
        },
        cancelSearch() {
            this.searchTerm = '';
            this.searchType = '';
            this.isSubmitted = false;
        },

        addToItinerary(event, destinationId) {
            
            if (event.target.checked) {
                
                this.itinerary.push(destinationId);
            } else {
                this.itinerary = this.itinerary.filter(destination =>{
                    return destination !== destinationId
                })
            }
        },

        postToItinerary() {
            this.itinerary.forEach((element) => {
                if(this.selectedItinerary !== element.itineraryId) {
                    ItineraryServices.addToItinerary(element, this.selectedItinerary)
                }
        });
            this.$router.push({name:"ItineraryDetail", params:{id:this.selectedItinerary}});
        },

        changeCreated() {
            if (this.showCreatedForm === true) {
                this.showCreatedForm = false;
            } else {
            this.showCreatedForm = true;
            }
        },

        createItinerary() {
            ItineraryServices.createItinerary(this.startingPoint, this.date).then(() => {
                if (this.showCreatedForm === true) {
                    this.showCreatedForm = false;
                } else {
                this.showCreatedForm = true;
                }
                ItineraryServices.getItineraryByUserId(this.$store.state.user.id).then((response) => {
                    this.userItineraries = response.data;
                })
            });
        },
        viewItinerary() {
             this.$router.push({name:"ItineraryDetail", params:{id:this.selectedItinerary}});
        }
    }
}
</script>

<style>  /* CSS goes here */
    #main {
        height: 100vmax;
    }
    
    label {
        color: white;
    }
    

    div h1 {
        font-size: 50px;
        color: white;
        font-family: "Lucida Handwriting", cursive;
        font-size: 80px;
        display: flex;
        justify-content: center;
    }

    div.destinations {
        display: flex;
        justify-content: center;
    }

    a {
        display: flex;
        justify-content: center;
        font-weight: bold;
        color:gainsboro;
    }

    a.destinationDetail {
        color: #034f84;
        background-color: #fefbd8;
        border-radius: 10px;
        width: 325px;
    }

    a:hover {
        color: RGB(73, 251, 53);
    }

    input {
        margin: 5px;
    }

    button {
        margin: 5px;
    }

    button:hover {
        color: blue;
    }

    ul {
        list-style: none;
    }

    li {
         color: white;
    }

   .select.active > span {
        background-color: white;
    }

    .center {
        display: flex;
        justify-content: center;
        margin: auto;
        margin-top: 15px;

    }
    .checks {
        display: flex;
        align-items: center;
        margin-top: 20px;
    }
</style>