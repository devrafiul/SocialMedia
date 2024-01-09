import { Avatar, Box, Button, Card, Tab, Tabs } from "@mui/material";
import React from "react";
import { useParams } from "react-router-dom";
import PostCard from "../../../Components/Post/PostCard";
import { UserReelCard } from "../../../Components/Reels/UserReelCard";

const tabs = [
  { value: "post", name: "Post" },
  { value: "reels", name: "Reels" },
  { value: "saved", name: "Saved" },
  { value: "repost", name: "Repost" },
];

const posts = [1, 1, 1, 1, 1];

const reels = [1, 1, 1, 1, 1, 1];

const savedPost = [1, 1, 1];

const Profile = () => {
  const { id } = useParams();

  const [value, setValue] = React.useState("post");

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <Card className="my-10 w-[70%]">
      <div className="rounder-md">
        <div className="h-[15 rem]">
          <img
            className="w-full h-full rounded-t-md"
            src="https://cdn.pixabay.com/photo/2018/04/18/14/26/background-image-3330583_1280.jpg"
          />
        </div>

        <div className="px-5 flex justify-between items-start mt-5 h-[5rem]">
          <Avatar
            className="tranform -translate-y-24"
            sx={{ width: "10rem", height: "10rem" }}
            src="https://media.istockphoto.com/id/1644243032/vector/human-symbol.jpg?s=612x612&w=0&k=20&c=Yb08L2DaH1rB16DA1kkFSut5nj_4Gt0fL9LnxOl2U9Q="
          />

          {true ? (
            <Button sx={{ borderRadius: "20px" }} variant="outlined">
              Edit Profile
            </Button>
          ) : (
            <Button variant="outlined">Follow</Button>
          )}
        </div>

        <div className="p-5">
          <div>
            <h1 className="py-1 font-bold text-xl">Abdul Mannan</h1>
            <p>@abdulmannan</p>
          </div>

          <div className="flex gap-2 items-center py-3">
            <span>41 post</span>
            <span>35 followers</span>
            <span>5 following</span>
          </div>

          <div>
            <p>This is my real social media</p>
          </div>

          <section>
            <Box sx={{ width: "100%", borderBottom: 1, borderColor: "divide" }}>
              <Tabs
                value={value}
                onChange={handleChange}
                aria-label="wrapped label tabs example"
              >
                {tabs.map((item) => (
                  <Tab value={item.value} label={item.name} wrapped />
                ))}
              </Tabs>
            </Box>

            <div className="flex justify-center">
              {value === "post" ? (
                <div className="space-y-5 w-[70%] my-10">
                  {posts.map((item) => (
                    <div className="border border-slate-100 rounded-md">
                      <PostCard />
                    </div>
                  ))}
                </div>
              ) : value === "reels" ? (
                <div className="flex justify-center flex-wrap gap-2 my-10">
                  {reels.map((item) => (
                    <UserReelCard />
                  ))}
                </div>
              ) : value === "saved" ? (
                <div className="space-y-5 w-[70%] my-10">
                  {posts.map((item) => (
                    <div className="border border-slate-100 rounded-md">
                      <PostCard />
                    </div>
                  ))}
                </div>
              ) : (
                <div>Repost</div>
              )}
            </div>
          </section>
        </div>
      </div>
    </Card>
  );
};

export default Profile;
