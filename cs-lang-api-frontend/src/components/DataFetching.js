import React, { useState, useEffect } from 'react'
import axios from 'axios';

const DataFetching = () => {
    const [posts, setPosts] = useState([])

    useEffect(() => {
        axios.get("https://raw.githubusercontent.com/apinanyogaratnam/Computer-Science-Languages-API/main/data.json")
            .then(res => {
                console.log(res)
                setPosts(res.data)
            }).catch(err => {
                console.log(err);
            })
    }, [])

    return (
        <div className="App">
                {
                    posts.map(post => (
                        <div className="float-container">
                            <h2 className="float-left">Language: {post.name}</h2>
                            <h2 className="float-right">year: {post.year}</h2>
                        </div>
                    ))
                }
        </div>
    )
}

export default DataFetching
