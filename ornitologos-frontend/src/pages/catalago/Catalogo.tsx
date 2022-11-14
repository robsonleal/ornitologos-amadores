
import Pagination from '@mui/material/Pagination/Pagination';
import axios from 'axios';
import {useEffect, useState } from 'react';
import Post from '../../models/Post';
import { BarraDeFerramentas } from '../../shared/components';
import { GridCard } from '../../shared/components/GridCard';
import { LayoutBaseDePagina } from '../../shared/layouts';

export const Catalago = () => {


  const [numeroPagina,setNumeroPagina]=useState(1);
  const [posts,setPosts]=useState<Post[]>([]);

useEffect(() => {

  getPosts()

}, [posts.length])

useEffect(() => {

  getPosts()

}, [numeroPagina])

  function getPosts(){
    axios.get(`https://jsonplaceholder.typicode.com/posts?_page=${numeroPagina}&_limit=5`)
    .then((response)=>{
      setPosts(response.data)
    })
  }

  const handleChange = (event: React.ChangeEvent<unknown>, value: number) => {
    setNumeroPagina(value)
    window.scroll(0,0)

  };

  return (
    <LayoutBaseDePagina
      titulo='Catálogo'
      barraDeFerramentas={<BarraDeFerramentas/>}
    >
      {
        posts.map(post=>(
          <GridCard key={post.id} value={post}/>
        ))
      }
      <Pagination count={10} onChange={handleChange}  />
    </LayoutBaseDePagina>
  );
};
