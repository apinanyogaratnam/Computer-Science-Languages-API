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
        <div>
            <ul>
                {
                    posts.map(post => (
                        <div className="float-container">
                            <h2 className="float-child">Language: {post.name}</h2>
                            <h2 className="float-child">year: {post.year}</h2>
                        </div>
                    ))}
            </ul>
        </div>
    )
}

export default DataFetching
