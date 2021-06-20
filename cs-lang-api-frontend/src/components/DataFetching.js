import React, { useState, useEffect } from 'react'
import axios from 'axios';

const DataFetching = () => {
    const [posts, setPosts] = useState([])

    useEffect(() => {
        axios.get("raw.githubusercontent.com/apinanyogaratnam/computer-science-languages-api/main/data.json")
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
                        <li key={post.id}>{post.title}</li>
                    ))}
            </ul>
        </div>
    )
}

export default DataFetching
