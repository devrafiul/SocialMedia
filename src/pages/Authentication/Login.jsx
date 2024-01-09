import React, { useState } from 'react';
import { ErrorMessage, Field, Formik, Form } from 'formik';
import { TextField } from '@mui/material';
import * as Yup from 'yup';
import { Button } from '@mui/material';
import { useDispatch } from 'react-redux';
import { loginUserAction } from '../../Redux/Auth/auth.action';

const initialValues = { email: '', password: '' };

const validationSchema = Yup.object({
  email: Yup.string().email('Invalid email').required('Email is required'),
  password: Yup.string().min(6, 'Password must be at least 6 characters').required('Password is required'),
});

export const Login = () => {
  const [formValue, setFormValue] = useState();

  const dispatch=useDispatch();


  const handleSubmit = (values) => {
    console.log('handle submit', values);

    dispatch(loginUserAction({data:values}))
  };

  return (
    <Formik
      onSubmit={handleSubmit}
      validationSchema={validationSchema}
      initialValues={initialValues} // Corrected typo here
    >
      <Form className="space-y-5">
        <div className="space-y-5">
          <div>
            <Field
              as={TextField}
              name="email"
              placeholder="Enter email here"
              type="email"
              // Corrected prop name from variant to size or variant based on your Material-UI version
              size="small"
              fullWidth
            />
            <ErrorMessage name="email" component="div" className="text-red-500" />
          </div>

          <div>
            <Field
              as={TextField}
              name="password"
              placeholder="Enter password here"
              type="password"
              // Corrected prop name from variant to size or variant based on your Material-UI version
              size="small"
              fullWidth
            />
            <ErrorMessage name="password" component="div" className="text-red-500" />
          </div>
        </div>

        <Button sx={{padding: ".8rem orem"}}
         type='submit' 
         fullWidth
         variant='contained'
         size='small'
           color='primary'
           
           >
            Login</Button>

      </Form>
    </Formik>
  );
};
