import React, { useState } from 'react'
import { ErrorMessage, Field, Formik,Form } from 'formik';
import * as Yup from 'yup'
import {Button,FormLabel, FormControlLabel, RadioGroup, TextField,Radio} from '@mui/material';
import { useDispatch } from 'react-redux';
import { loginUserAction, registerUserAction } from '../../Redux/Auth/auth.action';



const initialValues= {firstName:'', lastName:'',email:'' ,  password:'', gender:''};

const validationSchema =Yup.object({
  email:Yup.string().email("Invalid email").required("Email is required"),
  password:Yup.string().min(6,"Password must be at least 6 characters").required("Password  is required"),
})


export const Register = () => {

  const [gender,setGender ]=useState('');
  
  const dispatch=useDispatch();


  const handleSubmit = (values) =>{

    values.gender=gender;

    console.log('handle submit',values)

    dispatch(registerUserAction({data:values}))

  };


  const handleChange = (event) =>{

    setGender(event.target.value);
  }

  return (
   

    <Formik

      onSubmit={handleSubmit}
      initialValues={initialValues}
      validationSchema={validationSchema}
    >

      <Form className='space-y-5' >
        <div className='space-y-5'>

          <div>
            <Field as={TextField}
                   name='firstName'
                   type='text'
                   placeholder='Enter first name'
                   //variant='outlined'
                   size='small'
                   fullWidth

                />
          </div>

          <div>
            <Field as={TextField}
                    name='lastName'
                    type='text'
                    placeholder='Enter last name'
                    size='small'
                    fullWidth
            />

          </div>

          <div>
            <Field  as={TextField}
                    name="email"
                    placeholder="Enter email here"
                    type="email"
                    size="small"
                    fullWidth
            />

          <ErrorMessage name='email'
                        component="div"
                        className='text-red-500'
          
          
          />

          </div>

        <div>
          <Field as={TextField}
                name='password'
                type='password'
                placeholder='Enter password here'
                size='small'
                fullWidth
          />

          <ErrorMessage name='password'
                        component='div'
                        className='text-red-500'
          />

        </div>

        <div>
        <FormLabel id="gender">Gender</FormLabel>
        <RadioGroup
        onChange={handleChange}
        row
        aria-label="gender"
        name="gender"
      >
        <FormControlLabel value="female" control={<Radio />} label="Female" />
        <FormControlLabel value="male" control={<Radio />} label="Male" />
        <FormControlLabel value="other" control={<Radio />} label="Other" />
      
      </RadioGroup>

      <ErrorMessage 

        name='gender'
        component='div'
        className='text-red-500'

      />
        </div>


        </div>

        
        <Button sx={{padding: ".8rem orem"}}
         type='submit' 
         fullWidth
         variant='contained'
         size='small'
           color='primary'
           
           >
            Register</Button>

        

      </Form>


    </Formik>
  


  );
};
