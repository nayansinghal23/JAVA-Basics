// It helps one object to notify other objects about the changes in the state.
// It ensures different parts of your application are updated in real time.
// It keeps components loosely coupled as they don't need direct connection for interaction.


// Let's say you have a YouTube channel and you want to notify your subscribers when you upload a new video.
// One way is subscribers can constantly check for updates i.e. polling mechanism but that's a waste of resources.
// Instead, you can use the Observer pattern to notify subscribers when a new video is uploaded.

public class Main {
    public static void main(String[] args) {
        YoutubeChannel youtubeChannel = new YoutubeChannel();
        Subscriber subscriber = new Subscriber();
        youtubeChannel.subscribe(subscriber);
        youtubeChannel.notifyChanges();
    }
}