import axios from 'axios'

export const getItems = () =>{
  return axios.get("/v1/api/items").catch(err => err.response)
}
