import axios from 'axios'

/**
 * 翻訳のkey-value
 */
export function fetchMessages () {
  return axios.get('/web/api/messages').then(response => response.data)
}
