import axios from 'axios';
export default {

createItinerary() {
    return axios.post(`/createItinerary`); // send their starting point, date, landmarks, route
},

submitItinerary() { // finalize itinerary and generate route

},

getItineraryByUserId(userId) {
    return axios.get(`/itineraryUser/${userId}`);
},

getItineraryByItineraryId(itineraryId) {
    return axios.get(`/viewItineraryById/${itineraryId}`);
},

deleteItinerary(itineraryId) {
    return axios.delete(`/deleteItinerary/${itineraryId}`)
},

addToItinerary(destinationId, itineraryId) {
    return axios.post(`/addItinerary/${destinationId}/${itineraryId}`)
},

viewDestinationsByItineraryId(itineraryId) {
    return axios.get(`/viewDestinationsByItineraryId/${itineraryId}`)
}
}