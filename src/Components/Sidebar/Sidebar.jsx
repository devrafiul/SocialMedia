import React from 'react';
import { navigationMenu } from './SidebarNavigation';
import { Avatar, Divider, Menu, MenuItem, Button, Card } from '@mui/material';
import MoreVertIcon from '@mui/icons-material/MoreVert';

const Sidebar = () => {
  // State for controlling the Menu component
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);

  // Event handlers for opening and closing the Menu
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };

  return (
    <Card className='card h-screen flex flex-col justify-between py-5'>
      <div className='space-y-8 pl-5'>
        <div className=''>
          {/* Application logo */}
          <span className='logo font-bold text-xl'> Pundra Social</span>
        </div>

        <div className='space-y-8'>
          {/* Sidebar navigation items */}
          {navigationMenu.map((item) => (
            <div key={item.title} className='cursor-pointer  flex space-x-3 items-center'>
              {item.icon}
              <p className='text-xl'>{item.title}</p>
            </div>
          ))}
        </div>
      </div>

      <div className='pb-50'>
        <Divider />

        <div className='pl-5 flex items-center justify-between pt-5 '>
          {/* User information and profile menu */}
          <div className='flex items-center space-x-3'>
            <Avatar src='https://cdn.pixabay.com/photo/2016/08/31/11/54/icon-1633249_640.png' />
            <div>
              <p className='font-bold'>Code With Zosh</p>
              <p className='opacity-70'>@codewithzosh</p>
            </div>
          </div>

          {/* Button for opening the profile menu */}
          <Button
            id='basic-button'
            aria-controls={open ? 'basic-menu' : undefined}
            aria-haspopup='true'
            aria-expanded={open ? 'true' : undefined}
            onClick={handleClick}
          >
            <MoreVertIcon />
          </Button>

          {/* Profile menu */}
          <Menu
            id='basic-menu'
            anchorEl={anchorEl}
            open={open}
            onClose={handleClose}
            MenuListProps={{
              'aria-labelledby': 'basic-button',
            }}
          >
            <MenuItem onClick={handleClose}>Profile</MenuItem>
            <MenuItem onClick={handleClose}>My account</MenuItem>
            <MenuItem onClick={handleClose}>Logout</MenuItem>
          </Menu>
        </div>
      </div>
    </Card>
  );
};

export default Sidebar;
