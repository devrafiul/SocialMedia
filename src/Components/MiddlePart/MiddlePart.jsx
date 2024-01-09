import { Avatar,Card, IconButton ,Input } from '@mui/material'
import React from 'react'
import AddIcon from '@mui/icons-material/Add';
import StoryCircle from './StoryCircle';
import ImageIcon from '@mui/icons-material/Image';
import VideocamIcon from '@mui/icons-material/Videocam';
import ArticleIcon from '@mui/icons-material/Article';
import PostCard from '../Post/PostCard';


const story=[1,1,1,1,1]
const posts=[1,1,1,1,1]

const MiddlePart = () => {

const handleOpenCreatePostModel = () =>{

  console.log("open post model...")
}


  return (



    <div className='px-20'>

        <section className='flex items-center p-5 rounded-b-md'>

          <div  className='flex flex-col items-center mr-4 cursor-pointer' >
          <Avatar  sx={{width:'5rem',height:'5rem'}}
        //  src='https://cdn.pixabay.com/photo/2023/12/01/05/32/butterfly-8422900_640.jpg' 
          >
            <AddIcon sx={{fontSize:"3rem"}} />

          </Avatar>

          <p>New</p>
          </div>


          {story.map((item)=> <StoryCircle/>)}

        </section>


      <Card className="p-5 mt-5">
        <div className='flex justify-between'>

          <Avatar/>

          <Input readOnly
           className='outline-none w-[90%] bg-slate-100 
          
          rounded-full px-5 border-[#3b4050] border' 
          type='text' />

        </div>


        <div className='flex justify-center space-x-9 mt-5'>


        <div className='flex items-center'>
          <IconButton color='primary' onClick={handleOpenCreatePostModel}>

              <ImageIcon/>

              <span>media</span>

          </IconButton>

        </div>


        <div className='flex items-center'> 

          <IconButton color='primary' onClick={handleOpenCreatePostModel}>
              <VideocamIcon/>
              <span>video</span>
          </IconButton>

        </div>

        <div className='flex items-center'>
          <IconButton color='primary' onClick={handleOpenCreatePostModel}>

            <ArticleIcon/>
            <span>write Article</span>
          </IconButton>

        </div>


        </div>

      </Card>


      <div className='mt-5 space-y-5'>

        {posts.map((item)=><PostCard/>)}

        
      </div>


    </div>
  )
}

export default MiddlePart