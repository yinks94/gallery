import axios from 'axios'

export const getItems = () =>{
  return axios.get("/v1/api/cart/items").catch(err => err.response)
}

export const addItem = (itemId) =>{
  return axios.post("/v1/api/carts", {itemId}).catch(err => err.response)
}

export const removeItem = (itemId) =>{
  return axios.delete(`/v1/api/cart/items/${itemId}`).catch(err => err.response)
}
