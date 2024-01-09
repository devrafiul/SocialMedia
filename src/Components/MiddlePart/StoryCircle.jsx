import { Avatar } from '@mui/material'
import React from 'react'

const StoryCircle = () => {
  return (
    <div>

        <div className='flex flex-col items-center mr-4 cursor-pointer'>

            <Avatar  sx={{width: "5rem" , height:"5rem"}}  
                    src='https://cdn.pixabay.com/photo/2023/12/01/05/32/butterfly-8422900_640.jpg' 
            >
            </Avatar>
            <p>CodeWith ...</p>
        </div>

    </div>
  )
}

export default StoryCircle