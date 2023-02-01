const title= document.querySelector('.title');
const prev= document.querySelector('.prev');
const playPause= document.querySelector('.playPause');
const next= document.querySelector('.next');
const audio= document.querySelector('audio');

// song list
const songList =[
    {
        // 你的音乐的路径,下面两个xxx处同理
        path:"file/スパークル .mp3",
        // 你的音乐的名字，下面两个xxx处同理
        songName:"スパークル",
    },
    {
        path:"file/なんでもないや .mp3",
        songName:"なんでもないや",
    },

    {
        path:"file/夢灯籠.mp3",
        songName:"夢灯籠",
    },
     {
        path:"file/前前前世.mp3",
        songName:"前前前世",
    },
];

let songPlaying = false;

//play song
 const playSong = ()=>{
    songPlaying = true;
    audio.play();
    playPause.classList.add('active');
    playPause.innerHTML = '<span class="material-icons">pause</span>';
}

//pause song
const pauseSong = () => {
    songPlaying = false;
    audio.pause();
    playPause.classList.remove('active');
    playPause.innerHTML = ' <span class="material-icons">play_arrow</span>';

}
//play/pause song
document.querySelector('.playPause').addEventListener("click",() => (songPlaying? pauseSong() : playSong()));

//load song
const loadSong = (songList) => {
    title.textContent = songList.songName;
    audio.src = songList.path;//

}
let i = 0;
loadSong (songList[i]);

//previous song
const prevSong = () => {
    i--;
    if (i < 0){
        i = songList.length -1;
    }
    loadSong(songList[i]);
    playSong();
}

prev.addEventListener("click", prevSong);

//next song
const nextSong = () => {
    i++;
    if (i > (songList.length - 1)){
        i = 0;
    }
    loadSong(songList[i]);
    playSong();
}

next.addEventListener("click", nextSong);