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
                <label for="SearchBy">Search By :</label>

        <select name="SearchBy" id="Search By" v-model="searchType">
            <option value="zipcode">Zipcode</option>
            <option value="venutype">Venu Type</option>
            <option value="name">Name</option>
            <option value="listAll">List All</option>
        </select>
                 <button>Search</button>    <!-- might need to add something here -->
                 <router-link :to="{ name: 'register' }">Create an account</router-link>
            </form>
            <div v-else>
                <!-- Loop through destinations array and display names after search -->
                <ul>
                    <li v-for="destination in destinations" v-bind:key="destination.destinationId">
                        <router-link :to="{ name: 'DestinationDetail', params: { id: destination.destinationId}}">
                            {{ destination.name }}
                        </router-link>
                    </li>
                </ul>
                <button v-on:click="cancelSearch">Cancel</button>
            </div>
            <!--<router-link>See all landmarks</router-link> -->
    </div>
        </div>
        </div>
       <!-- <img href="https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-cont[…]F11%2Fskyline-cleveland-ohio-VISITCLEVELAND0917.jpg&q=85"></img> -->
</template>

<script> // Vue goes here
import DestinationService from '../services/DestinationServices';

export default {
    data() {
        return {
            destinations: [],
            errorMsg: '',
            searchTerm: '',
            searchType: '',
            isSubmitted: false,
            isLoading: false
        }
    },
    created() {

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
            }
        },
        cancelSearch() {
            this.searchTerm = '';
            this.searchType = '';
            this.isSubmitted = false;
        }
    }
}
</script>

<style>  /* CSS goes here */


    #main {
        height: 100vmax;
    }
    
    
    div.home {
        display: flex;
        flex-direction: column;
        justify-items: center;
        align-items: center;
    }

    div h1 {
        font-size: 50px;
        color: white;
        font-family: "Lucida Handwriting", cursive;
        font-size: 80px;
    }

    div.destinations {
        display: flex;
        justify-content: center;
    }

    a {
        display: flex;
        justify-content: center;
        font-weight: bold;
        color: white;
    }

    a:hover {
        color: RGB(73, 251, 53);
    }

    input {
        margin: 5px;
    }

    button {
        padding: 2px;
    }

    button:hover {
        color: blue;
    }


</style>