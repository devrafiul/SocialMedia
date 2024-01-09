import {
  Avatar,
  Card,
  CardContent,
  CardHeader,
  CardMedia,
  IconButton,
  Typography,
  CardActions,
} from "@mui/material";
import React from "react";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import { red } from "@mui/material/colors";
import FavoriteIcon from "@mui/icons-material/Favorite";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import ShareIcon from "@mui/icons-material/Share";
import ChatBubbleIcon from "@mui/icons-material/ChatBubble";
import BookmarkBorderIcon from "@mui/icons-material/BookmarkBorder";
import BookmarkIcon from "@mui/icons-material/Bookmark";

const PostCard = () => {
  return (
    <Card className="">
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            R
          </Avatar>
        }
        action={
          <IconButton aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
        title="Abdul Mannan"
        subheader="@abdulmannan"
      />

      <CardMedia
        component="img"
        height="194"
        image="https://cdn.pixabay.com/photo/2015/01/07/11/31/tigers-591359_640.jpg"
        alt="Paella dish"
      />

      <CardContent>
        <Typography variant="body2" color="text.secondary">
          A majestic tiger and his adorable cub, a bond woven in wilderness.
          From playful pounces to tender moments, they share a realm of love and
          strength. Nature's poetry, fierce protection, and gentle guidance
          unite in their untamed tale. 🐅🍼💖 #TigerLove #WildBond #NatureMagic
        </Typography>
      </CardContent>

      <CardActions className="flex justify-between" disableSpacing>
        <div>
          <IconButton>
            {true ? <FavoriteIcon /> : <FavoriteBorderIcon />}
          </IconButton>

          <IconButton>{<ShareIcon />}</IconButton>

          <IconButton>{<ChatBubbleIcon />}</IconButton>
        </div>

        <div>
          <IconButton>
            {true ? <BookmarkIcon /> : <BookmarkBorderIcon />}
          </IconButton>
        </div>
      </CardActions>
    </Card>
  );
};

export default PostCard;
